    package Model;

    public abstract class Pessoa {

        private String nome;
        private String login;
        private String cpf;

        public Pessoa(String nome, String login, String cpf){
            this.nome = nome;
            this.login = login;
            this.cpf = cpf;

        }


        //sets
        public void setNome(String nome){
            this.nome = nome;
        }

        public void setLogin(String login){
            this.login = login;
        }

        public void setCpf(String cpf){
            this.cpf = cpf;
        }

        //gets
        public String getNome(){
            return nome;
        }

        public String getLogin(){
            return login;
        }

        public String getCpf(){
            return cpf;
        }


        //metodo abstrati

        public abstract String getTipoPessoa();



    }
