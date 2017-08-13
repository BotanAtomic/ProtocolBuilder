package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntFlag extends Object implements INetworkType {

    private int protocolId = 473;
    private int mapId = 0;
    private int state = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.mapId);
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of TreasureHuntFlag.state.");
         }
    }

}