package com.ankamagames.dofus.network.messages.game.look;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AccessoryPreviewMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6517;
    private boolean _isInitialized = false;
    private EntityLook look;
    private FuncTree _looktree;


    public void serialize(ICustomDataOutput param1) {
         this.look.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserialize(param1);
    }

}