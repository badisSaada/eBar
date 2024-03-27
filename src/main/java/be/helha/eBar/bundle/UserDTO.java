package be.helha.eBar.bundle;

import java.util.HashMap;
import java.util.Map;

public class UserDTO
     {

        public static final String MESSAGE = "message";
        public static final String USER = "user";
        public static final String OPERATION_REUSSIE = "operationReussie";
        public static final String LISTE = "liste";
        public static final String NOM = "nom";

        private Map<String, Object> map = new HashMap<String, Object>();


        public UserDTO() {

            this.map.put(UserDTO.OPERATION_REUSSIE, true);
            this.map.put(UserDTO.MESSAGE, "");
        }
        public void put(String clef, Object valeur) {
            this.map.put(clef, valeur);
        }

        public Object get(String clef) {
            return this.map.get(clef);
        }

        public void vider() {
            this.map.clear();
        }
    }

