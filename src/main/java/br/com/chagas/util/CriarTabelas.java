package br.com.chagas.util;

import javax.persistence.Persistence;

public class CriarTabelas {
    
    private static final String PERSISTENCE_UNIT_NAME = "jjcPU";
   
    public static void main(String[] args) {

        Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
          
    }
}
