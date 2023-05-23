package com.warmer.web.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_atomic_index")
public class KgAtomicIndex {

    @TableId
    private Integer id;

    private String indexJudgeMethod;

    private String indexSymbol;

    private String indexValue;

    private String judgeValue;

    private String dataType;

    private String description;

    private String associateTableName;

}
