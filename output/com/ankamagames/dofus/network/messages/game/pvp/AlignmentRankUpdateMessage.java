package com.ankamagames.dofus.network.messages.game.pvp;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AlignmentRankUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6058;
    private boolean _isInitialized = false;
    private int alignmentRank = 0;
    private boolean verbose = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.alignmentRank < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentRank + ") on element alignmentRank.");
         }
         param1.writeByte(this.alignmentRank);
         param1.writeBoolean(this.verbose);
    }

    public void deserialize(ICustomDataInput param1) {
         this.alignmentRank = param1.readByte();
         if(this.alignmentRank < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentRank + ") on element of AlignmentRankUpdateMessage.alignmentRank.");
         }
         this.verbose = param1.readBoolean();
    }

}