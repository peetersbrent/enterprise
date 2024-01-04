package com.example.wedstrijd;

import com.example.wedstrijd.dto.WedstrijdRequest;
import com.example.wedstrijd.dto.WedstrijdResponse;
import com.example.wedstrijd.model.Wedstrijd;
import com.example.wedstrijd.repository.WedstrijdRepository;
import com.example.wedstrijd.service.WedstrijdService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest(classes = WedstrijdServiceTests.class)
public class WedstrijdServiceTests {
    @InjectMocks
    private WedstrijdService wedstrijdService;

    @Mock
    private WedstrijdRepository wedstrijdRepository;

    @Test
    public void testCreateWedstrijd() {

        int year = 1985;
        int month = 6;
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date wedstrijdDate = calendar.getTime();

        WedstrijdRequest wedstrijdRequest = new WedstrijdRequest();

        wedstrijdRequest.setScheidsrechterID(1L);
        wedstrijdRequest.setSkuCode("SKU123");
        wedstrijdRequest.setThuisTeam("Test ThuisTeam");
        wedstrijdRequest.setUitTeam("Test UitTeam");
        wedstrijdRequest.setDatum(wedstrijdDate);
        wedstrijdRequest.setScheidsrechterID(1L);
        wedstrijdRequest.setScore("0-0");

        wedstrijdService.createWedstrijd(wedstrijdRequest);
    }

    @Test
    public void testGetAllWedstrijd() {

        int year = 1985;
        int month = 6;
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date wedstrijdDate = calendar.getTime();
        // Arrange
        Wedstrijd wedstrijd = new Wedstrijd();
        wedstrijd.setScheidsrechterID(1L);
        wedstrijd.setSkuCode("SKU123");
        wedstrijd.setThuisTeam("Test ThuisTeam");
        wedstrijd.setUitTeam("Test UitTeam");
        wedstrijd.setDatum(wedstrijdDate);
        wedstrijd.setScore("0-0");


        when(wedstrijdRepository.findAll()).thenReturn(List.of(wedstrijd));

        // Act
        List<WedstrijdResponse> wedstrijdResponses = wedstrijdService.getAllWedstrijden();

        // Assert
        assertEquals(1, wedstrijdResponses.size());
        assertEquals(1L, wedstrijdResponses.get(0).getScheidsrechterID());
        assertEquals("SKU123", wedstrijdResponses.get(0).getSkuCode());
        assertEquals("Test ThuisTeam", wedstrijdResponses.get(0).getThuisTeam());
        assertEquals("Test UitTeam", wedstrijdResponses.get(0).getUitTeam());
        assertEquals(wedstrijdDate, wedstrijdResponses.get(0).getDatum());
        assertEquals("0-0", wedstrijdResponses.get(0).getScore());

        verify(wedstrijdRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllWedstrijdBySkuCode() {
        // Arrange
        int year = 1985;
        int month = 6;
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date wedstrijdDate = calendar.getTime();
        // Arrange
        Wedstrijd wedstrijd = new Wedstrijd();
        wedstrijd.setScheidsrechterID(1L);
        wedstrijd.setSkuCode("SKU123");
        wedstrijd.setThuisTeam("Test ThuisTeam");
        wedstrijd.setUitTeam("Test UitTeam");
        wedstrijd.setDatum(wedstrijdDate);
        wedstrijd.setScore("0-0");

        when(wedstrijdRepository.findWedstrijdBySkuCodeIn(List.of("SKU123"))).thenReturn(List.of(wedstrijd));

        // Act
        List<WedstrijdResponse> wedstrijdResponses = wedstrijdService.get(List.of("SKU123"));

        // Assert
        assertEquals(1, wedstrijdResponses.size());
        assertEquals(1L, wedstrijdResponses.get(0).getScheidsrechterID());
        assertEquals("SKU123", wedstrijdResponses.get(0).getSkuCode());
        assertEquals("Test ThuisTeam", wedstrijdResponses.get(0).getThuisTeam());
        assertEquals("Test UitTeam", wedstrijdResponses.get(0).getUitTeam());
        assertEquals(wedstrijdDate, wedstrijdResponses.get(0).getDatum());
        assertEquals("0-0", wedstrijdResponses.get(0).getScore());

        verify(wedstrijdRepository, times(1)).findWedstrijdBySkuCodeIn(Collections.singletonList(wedstrijd.getSkuCode()));
    }

    @Test
    public void testUpdateWedstrijd() {

        int year = 1985;
        int month = 6;
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date wedstrijdDate = calendar.getTime();

        // Arrange
        Wedstrijd wedstrijd = new Wedstrijd();
        wedstrijd.setScheidsrechterID(1L);
        wedstrijd.setSkuCode("SKU123");
        wedstrijd.setThuisTeam("Test ThuisTeam");
        wedstrijd.setUitTeam("Test UitTeam");
        wedstrijd.setDatum(wedstrijdDate);
        wedstrijd.setScore("0-0");

        when(wedstrijdRepository.findWedstrijdBySkuCode("SKU123")).thenReturn(wedstrijd);

        WedstrijdRequest updatedRequest = new WedstrijdRequest();
        updatedRequest.setSkuCode("SKU123");
        updatedRequest.setThuisTeam("Updated Test ThuisTeam");
        updatedRequest.setUitTeam("Updated Test UitTeam");
        updatedRequest.setDatum(wedstrijdDate);
        updatedRequest.setScore("Updated 0-0");
        // Act
        WedstrijdResponse updateWedstrijd =  wedstrijdService.update(updatedRequest);

        assertEquals("SKU123", updateWedstrijd.getSkuCode());
        assertEquals("Updated Test ThuisTeam", updateWedstrijd.getThuisTeam());
        assertEquals("Updated Test UitTeam", updateWedstrijd.getUitTeam());
        assertEquals(wedstrijdDate, updateWedstrijd.getDatum());
        assertEquals("Updated 0-0", updateWedstrijd.getScore());

    }
    @Test
    public void testDeleteWedstrijd() {

        int year = 1985;
        int month = 6;
        int day = 15;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date wedstrijdDate = calendar.getTime();

        // Arrange
        Wedstrijd wedstrijd = new Wedstrijd();
        wedstrijd.setScheidsrechterID(1L);
        wedstrijd.setSkuCode("SKU123");
        wedstrijd.setThuisTeam("Test ThuisTeam");
        wedstrijd.setUitTeam("Test UitTeam");
        wedstrijd.setDatum(wedstrijdDate);
        wedstrijd.setScore("0-0");

        when(wedstrijdRepository.findWedstrijdBySkuCode("SKU123")).thenReturn(wedstrijd);

        // Act
        wedstrijdService.delete("SKU123");

        // Assert
        verify(wedstrijdRepository, times(1)).findWedstrijdBySkuCode("SKU123");
    }
}
