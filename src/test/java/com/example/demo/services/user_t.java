package com.example.demo.services;

import com.example.demo.dto.user;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class user_t {
    @InjectMocks
    private user_s users;

    @Mock
    private user_m userm;

    @Test
    public void serachAllWork
            () {
        com.example.demo.user user1 = new com.example.demo.user("1", "name1", "123", null);
        com.example.demo.user user2 = new com.example.demo.user("2", "name2", "123", null);

        when(userm.findAll()).thenReturn(List.of(user1, user2));

        List<user> users = this.users.getAllElements();

        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("name1", users.get(0).getUser());
        assertEquals("name2", users.get(1).getUser());
    }

    @Test
    public void serachOneTime() {
        users.getAllElements();
        verify(userm, times(1)).findAll();
    }

    @Test
    public void serachBy() {
        when(userm.findAll()).thenReturn(List.of());
        List<user> users = this.users.getAllElements();
        assertNotNull(users);
    }

    @Test
    public void buscarTodosDebeRetornarListaDelTamañoCorrecto() {
        com.example.demo.user user1 = new com.example.demo.user("1", "name1", "123", null);
        com.example.demo.user user2 = new com.example.demo.user("2", "name1", "123", null);

        when(userm.findAll()).thenReturn(List.of(user1, user2));
        List<user> users = this.users.getAllElements();
        assertEquals(2, users.size());
    }

    @Test
    public void searchWork() {
        com.example.demo.user user = new com.example.demo.user("1", "name1", "123", null);

        when(userm.findById("1")).thenReturn(Optional.of(user));

        com.example.demo.dto.user userDto = users.getById("1");

        assertNotNull(userDto);
        assertEquals("1", userDto.getId());
        assertEquals("name1", userDto.getUser());
    }

    @Test
    public void searchNUll() {
        when(userm.findById("1")).thenReturn(Optional.empty());

        user user = users.getById("1");

        assertNull(user);
    }

    @Test
    public void serachException() {
        com.example.demo.user user = new com.example.demo.user("1", "name1", "123", null);

        when(userm.findById("1")).thenReturn(Optional.of(user));

        com.example.demo.dto.user userDto = users.getById("1");

        assertNotNull(userDto);
    }

    @Test
    public void serachNotNull() {
        when(userm.findById("1")).thenReturn(Optional.empty());

        user user = users.getById("1");

        assertNull(user);
    }


    @Test
    public void searchByIDcorrect() {
        users.getById("1");
        verify(userm, times(1)).findById("1");
    }

    @Test
    public void serachByID() {
        com.example.demo.user user = new com.example.demo.user("1", "name1", "123", null);

        when(userm.findByEmail("jose@email.com")).thenReturn(Optional.of(user));

        com.example.demo.dto.user userDto = users.getByEmail("jose@email.com");

        assertNotNull(userDto);
        assertEquals("1", userDto.getId());
    }

    @Test
    public void serach() {
        when(userm.findAll()).thenReturn(List.of());

        List<user> users = this.users.getAllElements();

        assertNotNull(users);
        assertTrue(users.isEmpty());
    }

    @Test
    public void save() {
        user userDto = new user("1", "name1", "123", null);
        com.example.demo.user user = new com.example.demo.user("1", "name1", "123", null);

        when(userm.save(any(com.example.demo.user.class))).thenReturn(user);

        com.example.demo.dto.user savedUser = users.save(userDto);

        assertNotNull(savedUser);
        assertEquals("1", savedUser.getId());
        assertEquals("name1", savedUser.getUser());
    }

    @Test
    public void saveError() {
        user user = new user("1", "name1", "123", null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            users.save(user);
        });

        assertEquals("User name and email cannot be null", exception.getMessage());
    }

    @Test
    public void saveUserCorrect() {
        user userDto = new user("1", "name1", "123", null);
        com.example.demo.user user = new com.example.demo.user("1", "name1", "123", null);

        when(userm.save(any(com.example.demo.user.class))).thenReturn(user);

        users.save(userDto);

        verify(userm, times(1)).save(any(com.example.demo.user.class));
    }

    @Test
    public void saveNotNull() {
        user userDto = new user("1", "name1", "123", null);
        com.example.demo.user user = new com.example.demo.user("2", "name1", "123", null);

        when(userm.save(any(com.example.demo.user.class))).thenReturn(user);

        com.example.demo.dto.user savedUser = users.save(userDto);

        assertNotNull(savedUser.getId());
    }

    @Test
    public void saveFine() {
        user userDto = new user("1", "name1", "123", null);
        com.example.demo.user user = new com.example.demo.user("2", "name1", "123", null);

        when(userm.save(any(com.example.demo.user.class))).thenReturn(user);

        com.example.demo.dto.user savedUser = users.save(userDto);

        assertEquals("Jose", savedUser.getUser());
    }


    @Test
    public void saveByID() {
        user userDto = new user("1", "name1", "123", null);
        com.example.demo.user user = new com.example.demo.user("2", "name1", "123", null);

        when(userm.save(any(com.example.demo.user.class))).thenReturn(user);

        com.example.demo.dto.user savedUser = users.save(userDto);

        assertNotNull(savedUser);
        assertEquals("1", savedUser.getId());
    }

    @Test
    public void updateWork() {
        com.example.demo.user user = new com.example.demo.user("1", "name1", "123", null);
        com.example.demo.dto.user userDto = new user("2", "name1", "123", null);

        when(userm.findById("1")).thenReturn(Optional.of(user));
        when(userm.save(any(com.example.demo.user.class))).thenReturn(user);

        com.example.demo.dto.user updatedUser = users.update(userDto, "1");

        assertNotNull(updatedUser);
        assertEquals("UPDATE", updatedUser.getUser());
    }

    @Test
    public void updateNull() {
        user user = new user(null, "name1", "123", null);

        when(userm.findById("1")).thenReturn(Optional.empty());

        user updatedUser = users.update(user, "1");

        assertNull(updatedUser);
    }

    @Test
    public void updateByID() {
        user user = new user("1", "name1", "123", null);
        users.update(user, "1");
        verify(userm, times(1)).findById("1");
    }

    @Test
    public void updateData() {
        com.example.demo.user user = new com.example.demo.user("1", "name1", "123", null);
        com.example.demo.dto.user userDto = new user("2", "name1", "123", null);

        when(userm.findById("1")).thenReturn(Optional.of(user));
        when(userm.save(any(com.example.demo.user.class))).thenReturn(user);

        users.update(userDto, "1");

        verify(userm, times(1)).save(any(com.example.demo.user.class));
    }

    @Test
    public void UpdateTest() {
        user user = new user("1", "name1", "123", null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            users.update(user, "1");
        });

        String expectedMessage = "Error";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void deleteWork() {
        doNothing().when(userm).deleteById("1");

        users.delete("1");

        verify(userm, times(1)).deleteById("1");
    }

    @Test
    public void deleetNotFound() {
        doNothing().when(userm).deleteById("1");

        assertDoesNotThrow(() -> users.delete("1"));
    }

    @Test
    public void deleteOneTime() {
        doNothing().when(userm).deleteById("1");

        users.delete("1");

        verify(userm, times(1)).deleteById("1");
    }

    @Test
    public void deleteByID() {
        doNothing().when(userm).deleteById("1");

        users.delete("1");

        verify(userm).deleteById(argThat(id -> id.equals("1")));
    }
}



