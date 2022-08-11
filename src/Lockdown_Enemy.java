public class Lockdown_Enemy {
    int health;
    int damage;
    int speed;
    String type;

    public Lockdown_Enemy(String type) {
        if(type == "Colds"){
            sickPersonColds();
        }

        if(type == "Fever"){
            sickPersonFever();
        }
    }


    public void sickPersonColds(){
        health = 100;
        damage = 10;
        speed = 1;
        type = "Colds";
    }

    public void sickPersonFever(){
        health = 150;
        damage = 20;
        speed = 2;
        type = "Fever";
    }
}
