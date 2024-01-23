insert into note (id, title, content, author, important, created_at) values (1, 'nota1', 'Element', 'juan', false, current_timestamp);
insert into note (id, title, content, author, important, created_at) values (2, 'nota2', 'Sentra', 'manolo', true, current_timestamp);
insert into note (id, title, content, author, important, created_at) values (3, 'nota3', 'H2', 'adrian', true, current_timestamp);

insert into note_tags (note_id, tags) values (1, 'compra');
insert into note_tags (note_id, tags) values (2, 'trabajo');
