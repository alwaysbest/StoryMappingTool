package nju.software.controller.response;

import lombok.*;
import nju.software.entity.Release;

/**
 * Time       : 2019/1/14 3:42 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/release response
 */
@Data
public class CreateOrUpdateReleaseResponse {
    private String status;

    private Release release;

}
