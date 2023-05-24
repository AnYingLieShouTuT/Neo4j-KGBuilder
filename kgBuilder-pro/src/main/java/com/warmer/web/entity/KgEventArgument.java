package com.warmer.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_event_argument")
public class KgEventArgument {
    private Integer id;
    private String argumentName;
    private String argumentSource;
    private String associateTablesName;
}
