package com.warmer.web.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_warning_index")
public class KgWarningIndex {

    @TableId
    private Integer id;

    private String indexName;

    private String indexJudgeMethod;

    private String level;

    private String andAtomicList;

    private String orAtomicList;

    private String notAtomicList;

}
