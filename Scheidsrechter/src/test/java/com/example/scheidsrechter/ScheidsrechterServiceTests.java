package com.example.scheidsrechter;

import com.example.scheidsrechter.dto.ScheidsrechterRequest;
import com.example.scheidsrechter.dto.ScheidsrechterResponse;
import com.example.scheidsrechter.model.Scheidsrechter;
import com.example.scheidsrechter.repository.ScheidsrechterRepository;
import com.example.scheidsrechter.service.ScheidsrechterService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class ScheidsrechterServiceTests {

    @InjectMocks
    private ScheidsrechterService scheidsrechterService;

    @Mock
    private ScheidsrechterRepository scheidsrechterRepository;
    @Test
    public void testCreateScheidsrechter() {

        ScheidsrechterRequest scheidsrechterRequest = new ScheidsrechterRequest();

        scheidsrechterRequest.setScheidsrechterID(1L);
        scheidsrechterRequest.setSkuCode("SKU123");
        scheidsrechterRequest.setNaam("Test Naam");
        scheidsrechterRequest.setMail("mail@gmail.com");
        scheidsrechterRequest.setNiveau("1ste Prov.");
        scheidsrechterRequest.setIsAssistent(true);

        scheidsrechterService.createScheidsrechter(scheidsrechterRequest);

        verify(scheidsrechterRepository, times(1)).save(any(Scheidsrechter.class));
    }

    @Test
    public void testGetAllScheidsrechter() {

        int year = 1985;
        int month = 6; // May
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date birthDate = calendar.getTime();
        // Arrange
        Scheidsrechter scheidsrechter = new Scheidsrechter();
        scheidsrechter.setScheidsrechterID(1L);
        scheidsrechter.setSkuCode("SKU123");
        scheidsrechter.setNaam("Test Naam");
        scheidsrechter.setMail("mail@gmail.com");
        scheidsrechter.setNiveau("1ste Prov.");
        scheidsrechter.setIsAssistent(true);
        scheidsrechter.setGeboortedatum(birthDate);


        when(scheidsrechterRepository.findAll()).thenReturn(List.of(scheidsrechter));

        // Act
        List<ScheidsrechterResponse> scheidsrechterResponses = scheidsrechterService.getAllScheidsrechters();

        // Assert
        assertEquals(1, scheidsrechterResponses.size());
        assertEquals("SKU123", scheidsrechterResponses.get(0).getSkuCode());
        assertEquals("Test Naam", scheidsrechterResponses.get(0).getNaam());
        assertEquals("1ste Prov.", scheidsrechterResponses.get(0).getNiveau());
        assertEquals(true, scheidsrechterResponses.get(0).getIsAssistent());

        verify(scheidsrechterRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllScheidsrechterBySkuCode() {
        // Arrange
        int year = 1985;
        int month = 6; // May
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date birthDate = calendar.getTime();
        // Arrange
        Scheidsrechter scheidsrechter = new Scheidsrechter();
        scheidsrechter.setScheidsrechterID(1L);
        scheidsrechter.setSkuCode("SKU123");
        scheidsrechter.setNaam("Test Naam");
        scheidsrechter.setMail("mail@gmail.com");
        scheidsrechter.setNiveau("1ste Prov.");
        scheidsrechter.setIsAssistent(true);
        scheidsrechter.setGeboortedatum(birthDate);

        when(scheidsrechterRepository.findScheidsrechterBySkuCodeIn(List.of("SKU123"))).thenReturn(List.of(scheidsrechter));

        // Act
        List<ScheidsrechterResponse> scheidsrechterResponses = scheidsrechterService.get(List.of("SKU123"));

        // Assert
        assertEquals(1, scheidsrechterResponses.size());
        assertEquals("SKU123", scheidsrechterResponses.get(0).getSkuCode());
        assertEquals("Test Naam", scheidsrechterResponses.get(0).getNaam());
        assertEquals("1ste Prov.", scheidsrechterResponses.get(0).getNiveau());
        assertEquals(true, scheidsrechterResponses.get(0).getIsAssistent());

        verify(scheidsrechterRepository, times(1)).findScheidsrechterBySkuCodeIn(Collections.singletonList(scheidsrechter.getSkuCode()));
    }

    @Test
    public void testUpdateScheidsrechter() {

        int year = 1985;
        int month = 6;
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date birthDate = calendar.getTime();

        int updateyear = 1990;
        int updatemonth = 10;
        int updateday = 18;

        Calendar updatecalendar = Calendar.getInstance();
        updatecalendar.set(updateyear, updatemonth, updateday);
        Date updatebirthDate = updatecalendar.getTime();

        // Arrange
        Scheidsrechter scheidsrechter = new Scheidsrechter();
        scheidsrechter.setScheidsrechterID(1L);
        scheidsrechter.setSkuCode("SKU123");
        scheidsrechter.setNaam("Test Naam");
        scheidsrechter.setMail("mail@gmail.com");
        scheidsrechter.setNiveau("1ste Prov.");
        scheidsrechter.setIsAssistent(true);
        scheidsrechter.setGeboortedatum(birthDate);

        when(scheidsrechterRepository.findScheidsrechterBySkuCode("SKU123")).thenReturn(scheidsrechter);

        ScheidsrechterRequest updatedRequest = new ScheidsrechterRequest();
        updatedRequest.setScheidsrechterID(1L);
        updatedRequest.setSkuCode("SKU123");
        updatedRequest.setNaam("Updated Test Naam");
        updatedRequest.setMail("updatedmail@gmail.com");
        updatedRequest.setNiveau("Updated 1ste Prov.");
        updatedRequest.setIsAssistent(false);
        updatedRequest.setGeboortedatum(updatebirthDate);

        // Act
        ScheidsrechterResponse updateScheidsrechter = scheidsrechterService.update(updatedRequest);

        assertEquals("SKU123", updateScheidsrechter.getSkuCode());
        assertEquals("Updated Test Naam", updateScheidsrechter.getNaam());
        assertEquals("updatedmail@gmail.com", updateScheidsrechter.getMail());
        assertEquals("Updated 1ste Prov.", updateScheidsrechter.getNiveau());
        assertEquals(false, updateScheidsrechter.getIsAssistent());
        assertEquals(updatebirthDate, updateScheidsrechter.getGeboortedatum());
        assertFalse(scheidsrechter.getIsAssistent());

        // Assert
        verify(scheidsrechterRepository, times(1)).save(any(Scheidsrechter.class));
    }

    @Test
    public void testDeleteScheidsrechter() {

        int year = 1985;
        int month = 6;
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date birthDate = calendar.getTime();

        // Arrange
        Scheidsrechter scheidsrechter = new Scheidsrechter();
        scheidsrechter.setScheidsrechterID(1L);
        scheidsrechter.setSkuCode("SKU123");
        scheidsrechter.setNaam("Test Naam");
        scheidsrechter.setMail("mail@gmail.com");
        scheidsrechter.setNiveau("1ste Prov.");
        scheidsrechter.setIsAssistent(true);
        scheidsrechter.setGeboortedatum(birthDate);

        when(scheidsrechterRepository.findScheidsrechterBySkuCode("SKU123")).thenReturn(scheidsrechter);

        // Act
        scheidsrechterService.delete("SKU123");

        // Assert
        verify(scheidsrechterRepository, times(1)).findScheidsrechterBySkuCode("SKU123");
    }
}
