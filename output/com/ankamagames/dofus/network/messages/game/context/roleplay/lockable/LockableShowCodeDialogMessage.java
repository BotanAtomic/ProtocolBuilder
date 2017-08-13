package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LockableShowCodeDialogMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5740;
    private boolean _isInitialized = false;
    private boolean changeOrUse = false;
    private int codeSize = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.changeOrUse);
         if(this.codeSize < 0)
         {
            throw new Exception("Forbidden value (" + this.codeSize + ") on element codeSize.");
         }
         param1.writeByte(this.codeSize);
    }

    public void deserialize(ICustomDataInput param1) {
         this.changeOrUse = param1.readBoolean();
         this.codeSize = param1.readByte();
         if(this.codeSize < 0)
         {
            throw new Exception("Forbidden value (" + this.codeSize + ") on element of LockableShowCodeDialogMessage.codeSize.");
         }
    }

}