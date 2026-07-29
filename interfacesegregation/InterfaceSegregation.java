package interfacesegregation;

public class InterfaceSegregation {
    
    public InterfaceSegregation() {
        doIncorrectImplementation();
    }
    

    public void doIncorrectImplementation() {
        /**
         * Crow e Penguin classes implementam a interface Bird
         */
        interfacesegregation.incorrect.Crow crow = new interfacesegregation.incorrect.Crow();
        interfacesegregation.incorrect.Penguin penguin = new interfacesegregation.incorrect.Penguin();
        
        /**
         * Os metodos funcionam bem para um passaro que pode comer, dormir e voar
         */
        crow.eat();
        crow.sleep();
        crow.fly();
        
         /**
         * Os metodos nao funcionam bem para o Penguin que pode comer e dormir, 
         * mas nao pode voar
         */
        penguin.eat();
        penguin.sleep();
        penguin.fly();
    }
    
    public void doCorrectImplementation() {
        
        /**
         * Adicione aqui seu código refatorado com referências a métodos e classes 
         * contidas no pacote interfacesegregation.correct
         */
        
        
    }
    
    public static void main(String [] args) {
        InterfaceSegregation is = new InterfaceSegregation();
    }
    
}
