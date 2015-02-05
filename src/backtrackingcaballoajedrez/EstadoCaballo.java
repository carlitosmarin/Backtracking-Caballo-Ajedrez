package backtrackingcaballoajedrez;

/**
 *
 * @Autor: Carlos Marin Fernandez
 * @Fecha: 26-ene-2015
 * @Descripcion: Localizacion del caballo y el numero de saltos realizados
 *
 */
public class EstadoCaballo {
    
     public int posX, posY, saltosCompletados = 0; 

    public EstadoCaballo(int x, int y, int n) {
        this.posX = x;
        this.posY = y;
        this.saltosCompletados = n;
    }
    
    public EstadoCaballo operador1(EstadoCaballo ec){
        ec.saltosCompletados++;
        ec.posX = ec.posX - 1;
        ec.posY = ec.posY + 2;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }
    
    public EstadoCaballo operador2(EstadoCaballo ec){
        ec.saltosCompletados++;
        ec.posX = ec.posX - 2;
        ec.posY = ec.posY + 1;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }
    
    public EstadoCaballo operador3(EstadoCaballo ec){
        ec.saltosCompletados++;
        ec.posX = ec.posX - 2;
        ec.posY = ec.posY - 1;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }
    
    public EstadoCaballo operador4(EstadoCaballo ec){
        ec.saltosCompletados++;
        ec.posX = ec.posX - 1;
        ec.posY = ec.posY - 2;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }
    
    public EstadoCaballo operador5(EstadoCaballo ec){
        ec.saltosCompletados = ec.saltosCompletados + 1;
        ec.posX = ec.posX + 1;
        ec.posY = ec.posY - 2;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }
    
    public EstadoCaballo operador6(EstadoCaballo ec){
        ec.saltosCompletados++;
        ec.posX = ec.posX + 2;
        ec.posY = ec.posY - 1;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }
    
    public EstadoCaballo operador7(EstadoCaballo ec){
        ec.saltosCompletados++;
        ec.posX = ec.posX + 2;
        ec.posY = ec.posY + 1;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }
    
    public EstadoCaballo operador8(EstadoCaballo ec){
        ec.saltosCompletados++;
        ec.posX = ec.posX + 1;
        ec.posY = ec.posY + 2;
        return new EstadoCaballo(posX,posY,saltosCompletados);
    }

    @Override
    public String toString() {
        return "EstadoCaballo:\n" + "x = " + posX + " y = " + posY + " n = " + saltosCompletados;
    }     
}