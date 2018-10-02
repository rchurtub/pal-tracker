package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String PORT;
    private String MEMORY_LIMIT;
    private String CF_INSTANCE_INDEX;
    private String CF_INSTANCE_ADDR;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memory_limit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String cf_instance_index,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cf_instance_addr) {
        PORT = port;
        MEMORY_LIMIT = memory_limit;
        CF_INSTANCE_INDEX = cf_instance_index;
        CF_INSTANCE_ADDR = cf_instance_addr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("PORT", PORT);
        map.put("MEMORY_LIMIT", MEMORY_LIMIT);
        map.put("CF_INSTANCE_INDEX",CF_INSTANCE_INDEX);
        map.put("CF_INSTANCE_ADDR",CF_INSTANCE_ADDR);

        return map;
    }
}
