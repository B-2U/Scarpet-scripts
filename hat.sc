//put sth on your head
//by _GieR


__config() -> (
   m(
      l('stay_loaded','true')
   )
);


__command() -> (
   mainhand_slot = player() ~ 'selected_slot';
   item = player() ~ ['holds','mainhand'];
   head = player() ~ ['holds','head'];
        
   inventory_set(player(), mainhand_slot, head:1, head:0, head:2);
   inventory_set(player(), 39, item:1, item:0, item:2);

   null
)
