/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbse.example.service;

import com.cbse.example.entity.Palindrome;
import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class PalindromeService implements PalindromeServiceRemote {

    @Override
    public Palindrome createPalindrome (String input) {
        Palindrome p = new Palindrome();
        p.setInput(input);
        return p;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
