insert into note_tags (note_id, tags) values (1L, 'compra');
insert into note_tags (note_id, tags) values (2L, 'trabajo');

insert into note (id, title, content, author, important, tags) values (1L, 'nota1', 'Element', 'juan', false, 1);
insert into note (id, title, content, author, important, tags) values (2L, 'nota2', 'Sentra', 'manolo', true, 2);
insert into note (id, title, content, author, important, tags) values (3L, 'nota3', 'H2', 'adrian', true, 2);
