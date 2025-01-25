CREATE TABLE IF NOT EXISTS public.personne
(
  username character varying(50) COLLATE pg_catalog."default" NOT NULL,
  password character varying(100) COLLATE pg_catalog."default" NOT NULL,
  role character varying(100) COLLATE pg_catalog."default",
  CONSTRAINT personne_pkey PRIMARY KEY (username)
)

CREATE TABLE IF NOT EXISTS public.secret
(
  champ character varying COLLATE pg_catalog."default" NOT NULL,
  valeur character varying COLLATE pg_catalog."default",
  CONSTRAINT secret_pkey PRIMARY KEY (champ)
)

  INSERT INTO public.personne (username, password, role) VALUES
('john_doe', 'password123', 'admin'),
('jane_smith', '12345', 'user'),
('alice_taylor', 'mypassword', 'manager'),
('bob_brown', 'qwerty', 'user'),
('carol_white', 'password1', 'user'),
('david_miller', 'davidpass', 'admin'),
('emma_jones', 'hello123', 'manager'),
('frank_clark', 'abc123', 'user'),
('george_harris', 'securepassword', 'admin'),
('harry_wilson', 'wilson123', 'user');

INSERT INTO public.secret (champ, valeur) VALUES
                                            ('api_key', '12345-abcdef-67890'),
                                            ('db_password', 'supersecretpassword'),
                                            ('encryption_key', 'encryptionkeyvalue'),
                                            ('server_address', '192.168.1.1'),
                                            ('admin_email', 'admin@example.com');
