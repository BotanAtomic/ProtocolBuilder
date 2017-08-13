package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class IgnoredDeleteResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5677;
    private boolean _isInitialized = false;
    private boolean success = false;
    private String name = "";
    private boolean session = false;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.session);
         param1.writeByte(_loc2_);
         param1.writeUTF(this.name);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.session = BooleanByteWrapper.getFlag(_loc2_,1);
         this.name = param1.readUTF();
    }

}