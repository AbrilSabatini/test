package org.mock.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.persistence.repository.ImplPlayerRepository;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ImplPlayerServiceTest {

    // Forma 1
    /*
    private ImplPlayerRepository playerRepository; // Usar implementaciones, no interface
    private ImplPlayerService playerService;
    @BeforeEach
    void init() {
        this.playerRepository = mock(ImplPlayerRepository.class);
        this.playerService = new ImplPlayerService(playerRepository);
    }*/

    // Forma 2
    /*
    @Mock

    private ImplPlayerRepository playerRepository; // Usar implementaciones, no interface

    @InjectMocks
    private ImplPlayerService playerService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }*/

    // Forma 3
    // -> Usando @ExtendWith(MockitoExtension.class)
    @Mock
    private ImplPlayerRepository playerRepository; // Usar implementaciones, no interface

    @InjectMocks
    private ImplPlayerService playerService;

    @Test
    public void testFindAll() {
        // Given
        List<Player> playerList = DataProvider.playerListMock();

        // When
        when(playerRepository.findAll()).thenReturn(playerList);
        List<Player> result = playerService.findAll();

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(playerList.getFirst().getName(), result.getFirst().getName());
        assertEquals(playerList.getFirst().getTeam(), result.getFirst().getTeam());
        assertEquals(playerList.getFirst().getPosition(), result.getFirst().getPosition());
    }

    @Test
    public void testFindById() {
        // Given
        Player expectedPlayer = DataProvider.playerMock();
        Long id = expectedPlayer.getId();

        // When
        when(playerRepository.findPlayerById(id)).thenReturn(expectedPlayer);
        Player result = this.playerService.findPlayerById(id);

        // Then
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(expectedPlayer.getName(), result.getName());
        verify(this.playerRepository).findPlayerById(id); // Valida que se haya llamado al método
    }

    @Test
    public void testSave() {
        // Given
        Player newPlayer = DataProvider.newPlayerMock();

        // When
        this.playerService.savePlayer(newPlayer);

        // Then
        ArgumentCaptor<Player> playerCaptor = ArgumentCaptor.forClass(Player.class); // captura el argumento de tipo Player pasados al mock
        verify(this.playerRepository).savePlayer(playerCaptor.capture());

        assertEquals(newPlayer.getId(), playerCaptor.getValue().getId());
        assertEquals(newPlayer.getName(), playerCaptor.getValue().getName());
        assertEquals(newPlayer.getPosition(), playerCaptor.getValue().getPosition());
    }

    @Test
    public void testDeleteById() {
        // Given
        Long id = 1L;

        // When
        this.playerService.deletePlayer(id);

        // Then
        ArgumentCaptor<Long> idCapture = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deletePlayer(idCapture.capture());

        assertEquals(id, idCapture.getValue());
    }
}
