package org.example.car.exception;

public class ModelNotFoundException extends BusinessException{
    public ModelNotFoundException(){
        super("Le modèle donné n'existe pas !");
    }
}
