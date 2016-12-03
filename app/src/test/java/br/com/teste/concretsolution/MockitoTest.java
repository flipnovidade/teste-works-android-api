package br.com.teste.call;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.teste.call.activity.MainActivity;
import br.com.teste.call.adapter.ListaRegisterRecyclerViewAdapter;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    MainActivity mainActivity;

    @Mock
    ListaRegisterRecyclerViewAdapter listaRegisterRecyclerViewAdapter;


    @Before
    public void setUp() throws Exception {
        mainActivity = Mockito.mock(MainActivity.class);
        listaRegisterRecyclerViewAdapter = Mockito.mock(ListaRegisterRecyclerViewAdapter.class);
    }


    @Test
    public void addItemList() throws Exception {

//        listaRegisterRecyclerViewAdapter.addList(FakeObjectsRepository.getListShots());
//        assertEquals(2, listaRegisterRecyclerViewAdapter.getItemCount());
//
//        listaRegisterRecyclerViewAdapter.addList(FakeObjectsRepository.getListShots());
//        assertEquals(4, listaRegisterRecyclerViewAdapter.getItemCount());

    }

    @Test
    public void checkResponseServiceRest() throws Exception {

        //CallApi callApi = Mockito.mock( CallApi.class );
        //String response = "[]";
//        ApiModule service = Mockito.mock( ApiModule.class );
//        OngoingStubbing<Class<Response>> objectCall = Mockito.when( Response.class );
//        assertEquals(200, objectCall.hashCode() );

    }
}