package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatedElementUpdatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5709;
    private boolean _isInitialized = false;
    private StatedElement statedElement;
    private FuncTree _statedElementtree;


    public void serialize(ICustomDataOutput param1) {
         this.statedElement.serializeAs_StatedElement(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.statedElement = new StatedElement();
         this.statedElement.deserialize(param1);
    }

}