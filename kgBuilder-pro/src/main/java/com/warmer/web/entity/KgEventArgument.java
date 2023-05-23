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
    private String argument_name;
    private String argument_source;
    private String associate_tables_name;
}
