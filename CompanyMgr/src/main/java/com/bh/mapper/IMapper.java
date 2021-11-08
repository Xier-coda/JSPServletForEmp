package com.bh.mapper;

import java.sql.ResultSet;
import java.util.List;

public interface IMapper {
	
	public List map(ResultSet rs) throws Exception;
	
}
