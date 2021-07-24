// show other guys where you are
// By _GieR


__config() -> (
    m(
        l('stay_loaded','true')
    )
);


__command() -> (
    location = pos(player());
    dimension = query(player(),'dimension');
    c_for(d=0,d<3,d+=1,
        put(location, d, round(location:d));
    );
    if(
        dimension == 'overworld',
            info = format('c Overworld '+location);

        dimension == 'the_nether',
            info = format('n Nether '+location);

        dimension == 'the_end',
            info = format('p End '+location),
            
            info = 'Unknown dimension';
   );
    player = format('i '+player());
    print(player('all'), player+' @ '+info);
    run('effect give '+player()+' glowing 15');
    

    null
)