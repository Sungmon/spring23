package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;

import lombok.Setter;

@Service
public class SampleServiceImpl implements SampleService {

	@Setter(onMethod_ = { @Autowired })
	private Sample1Mapper mapper1;

	@Setter(onMethod_ = { @Autowired })
	private Sample2Mapper mapper2;

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {

		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

}
