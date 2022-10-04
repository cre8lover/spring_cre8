package com.cre8.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.Att;
import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;
import com.cre8.dto.filedelVO;
import com.cre8.dto.prodelVo;

public interface CreatorMapper {
	
	List<Marketing> getlist();

	public void Creatoradd(Creator cre);

	public void mk(Marketing m);

	public int cremodifyreg(Pro p);

	public int prodel(String seqno);

	public int infomodify(Creator c);

	public int add(Creator cre);

	public int aucdel(Auc auc);
	
	public filedelVO aucfiledel(Auc auc);
}
