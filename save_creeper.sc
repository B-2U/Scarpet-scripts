//prevent creeper destroy blocks
//by _GieR


__config() -> (
   m(
      l('stay_loaded','true')
   )
);


__on_explosion_outcome(pos, power, source, causer, mode, fire, blocks, entities)->(
    if(source == 'Creeper',
        for(blocks, without_updates(set(pos(_), 'air')));
        schedule(0, '_fill', blocks);       
    );
);      

_fill(blocks)->(
    for(blocks, without_updates(set(pos(_), _))) 
    )
)