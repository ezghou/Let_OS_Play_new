public class Lockdown_Character {
    int health;
    int damage;
    int attackSpeed;
    String type;

    public Lockdown_Character(String type) {
        if(type == "taxPayer"){
            taxPayer();
        }

        if(type == "doctor"){
            doctor();
        }
        if(type == "nurse"){
            nurse();
        }

        if(type == "soldier"){
            soldier();
        }
    }


    public void taxPayer(){
        health = 100;
        damage = 0;
        attackSpeed = 1;
        type = "taxPayer";
    }

    public void doctor(){
        health = 200;
        damage = 20;
        attackSpeed = 1;
        type = "doctor";
    }

    public void nurse(){
        health = 150;
        damage = 10;
        attackSpeed = 2;
        type = "nurse";
    }
    public void soldier(){
        health = 500;
        damage = 0;
        attackSpeed = 0;
        type = "soldier";
    }
}
