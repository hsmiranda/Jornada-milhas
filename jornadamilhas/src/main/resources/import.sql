-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO public.depoimento (id, depoimento, nomepessoa) VALUES(nextval('depoimento_seq'),'Joao', 'Excelente viagem gostei muito');
INSERT INTO public.depoimento (id, depoimento, nomepessoa) VALUES(nextval('depoimento_seq'),'Maria', 'Pior experiencia da minha vida');
INSERT INTO public.depoimento (id, depoimento, nomepessoa) VALUES(nextval('depoimento_seq'),'Pedro', 'Não estava espertando, mais foi bom');
