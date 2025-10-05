package com.example.ApiGateWay.Dto;

import com.google.protobuf.Any;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.AnyType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class filterParams {

    private String key;
    private AnyType value;

}
