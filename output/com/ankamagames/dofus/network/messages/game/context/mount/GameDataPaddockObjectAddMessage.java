package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameDataPaddockObjectAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5990;
    private boolean _isInitialized = false;
    private PaddockItem paddockItemDescription;
    private FuncTree _paddockItemDescriptiontree;


    public void serialize(ICustomDataOutput param1) {
         this.paddockItemDescription.serializeAs_PaddockItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.paddockItemDescription = new PaddockItem();
         this.paddockItemDescription.deserialize(param1);
    }

}