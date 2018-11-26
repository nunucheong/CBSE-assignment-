/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbse.example.service;

import com.cbse.example.entity.Palindrome;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface PalindromeServiceRemote {

    Palindrome createPalindrome (String input);
    
}
