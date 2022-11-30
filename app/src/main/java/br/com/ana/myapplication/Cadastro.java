package br.com.ana.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Cadastro implements Parcelable {
     String nome;
     String cpf;
     String altura;
     String peso;
     boolean status;
/////////////construindo a classe Cadastro
    public Cadastro (){}
    public Cadastro(String nome, String cpf, String altura, String peso, Boolean status){
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.cpf = cpf;
        this.status = status;



///////////serializando a classe Cadastro
    }

    @Override
    public String toString() {
        return "Cadastro{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                ", status=" + status +
                '}';
    }

    protected Cadastro(Parcel in) {
        nome = in.readString();
        cpf = in.readString();
        altura = in.readString();
        peso = in.readString();
        status = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(cpf);
        dest.writeString(altura);
        dest.writeString(peso);
        dest.writeByte((byte) (status ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cadastro> CREATOR = new Creator<Cadastro>() {
        @Override
        public Cadastro createFromParcel(Parcel in) {
            return new Cadastro(in);
        }

        @Override
        public Cadastro[] newArray(int size) {
            return new Cadastro[size];
        }
    };
}
