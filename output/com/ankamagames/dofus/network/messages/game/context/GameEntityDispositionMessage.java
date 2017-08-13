package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.IdentifiedEntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameEntityDispositionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5693;
    private boolean _isInitialized = false;
    private IdentifiedEntityDispositionInformations disposition;
    private FuncTree _dispositiontree;


    public void serialize(ICustomDataOutput param1) {
         this.disposition.serializeAs_IdentifiedEntityDispositionInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.disposition = new IdentifiedEntityDispositionInformations();
         this.disposition.deserialize(param1);
    }

}