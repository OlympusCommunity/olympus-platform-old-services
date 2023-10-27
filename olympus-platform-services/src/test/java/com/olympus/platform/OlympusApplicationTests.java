package com.olympus.platform;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OlympusApplicationTests {

  @Test
  public void contextLoads() {
    // este método usa el properties indicado en TestPropertySource y así se prueba
    // el caso de CORS desactivado.
  }

  @Test
  public void main() {
    OlympusApplication.main(new String[] {});
  }
}
