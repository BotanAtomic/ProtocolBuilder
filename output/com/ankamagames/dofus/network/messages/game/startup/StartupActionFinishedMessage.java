package com.ankamagames.dofus.network.messages.game.startup;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class StartupActionFinishedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1304;
    private boolean _isInitialized = false;
    private boolean success = false;
    private int actionId = 0;
    private boolean automaticAction = false;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.automaticAction);
         param1.writeByte(_loc2_);
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeInt(this.actionId);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.automaticAction = BooleanByteWrapper.getFlag(_loc2_,1);
         this.actionId = param1.readInt();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of StartupActionFinishedMessage.actionId.");
         }
    }

}