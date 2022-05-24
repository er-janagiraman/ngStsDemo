package com.fa.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fa.Entity.NgEntity;
import com.fa.Repository.LoginRespository;
import com.fa.Repository.NgRepository;
import com.fa.dto.CommonDto;
import com.fa.dto.NgDto;
import com.fa.service.NgService;

@Service
public class NgServiceImpl implements NgService {

	@Resource
	NgRepository ngReporistory;
	
	@Resource
	LoginRespository  loginRespository ;
	
	@Override
	public CommonDto save(NgDto ngDto) {
		CommonDto response = new CommonDto();
		try {
			if (ngDto != null) {
				NgEntity ng = new NgEntity();
				ng.setDob(ngDto.getDob());
				ng.setEmail(ngDto.getEmail());
				ng.setGender(ngDto.getGender());
				ng.setMobile(ngDto.getMobile());
				ng.setName(ngDto.getName());
//				ng.setSkills(ngDto.getSkills);
				ng.setTeam(ngDto.getTeam());
				ng.setPassword(ngDto.getPassword());

				ngReporistory.save(ng);
				response.setStatus("Success");

			}
		} catch (Exception e) {
			response.setStatus("Failed");
		}
		return response;
	}

	@Override
	public CommonDto fetch() {
		List<NgEntity> list = ngReporistory.findAll();
		CommonDto cDto = new CommonDto();
		try {
			cDto.setResponseDto(list);
		} catch (Exception e) {
			cDto.setResponseDto(null);
		}
		return cDto;
	}

	@Override
	public CommonDto edit(NgDto ngDto) {
		CommonDto response = new CommonDto();

		try {
			if (ngDto != null) {
				NgEntity ng = ngReporistory.getDataByName(ngDto.getName());
				ng.setMobile(ngDto.getMobile());
				ng.setDob(ngDto.getDob());
				ng.setEmail(ngDto.getEmail());
				ng.setGender(ngDto.getGender());
				ng.setTeam(ngDto.getTeam());
				ng.setPassword(ngDto.getPassword());
				ngReporistory.save(ng);
				response.setStatus("Success");
			}
		} catch (Exception e) {
			response.setStatus("Failed");
		}
		return response;
	}

	@Override
	public CommonDto delete(String ngDto) {
		CommonDto response = new CommonDto();
		try {
			 NgEntity entity = ngReporistory.getDataByName(ngDto);
			 ngReporistory.deleteById(entity.getId());
			 response.setStatus("Success");
			
		} catch (Exception e) {
			response.setStatus("Failed");
		}
		return response;
	}

	@Override
	public CommonDto register(NgDto ngDto) {
		CommonDto response = new CommonDto();
		try {
			if (ngDto != null) {
				NgEntity ng = new NgEntity();
				ng.setEmail(ngDto.getEmail());
				ng.setName(ngDto.getName());
				ng.setPassword(ngDto.getPassword());

				ngReporistory.save(ng);
				response.setStatus("Success");

			}
		} catch (Exception e) {
			response.setStatus("Failed");
		}
		return response;
	}

	@Override
	public CommonDto login(NgDto ngDto) {
		
		CommonDto response = new CommonDto();
		
		String email = ngDto.getEmail();
		String password = ngDto.getPassword();
		System.err.println(email+" "+password);
//		System.err.println(ngReporistory.getDataByEmail(email)+" "+ngReporistory.getDataByPassword(email));
		try {
			if (ngDto.getEmail().equalsIgnoreCase(ngReporistory.getDataByEmail(email))
					&& password.equalsIgnoreCase(ngReporistory.getDataByPassword(email))) {
				
				response.setStatus("Success");
			}
			
		} catch (Exception e) {
			response.setStatus("Failed");
		}

		return response;
	}

}
