package com.warmer.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_event")
public class KgEvent {
    private Integer id;
    private String eventType;
    private String eventTrigger;
    private String eventArgument;
    private String eventArgumentId;
}
