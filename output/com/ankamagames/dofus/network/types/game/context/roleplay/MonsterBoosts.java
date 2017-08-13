package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MonsterBoosts extends Object implements INetworkType {

    private int protocolId = 497;
    private int id = 0;
    private int xpBoost = 0;
    private int dropBoost = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarInt(this.id);
         if(this.xpBoost < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBoost + ") on element xpBoost.");
         }
         param1.writeVarShort(this.xpBoost);
         if(this.dropBoost < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBoost + ") on element dropBoost.");
         }
         param1.writeVarShort(this.dropBoost);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readVarUhInt();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of MonsterBoosts.id.");
         }
         this.xpBoost = param1.readVarUhShort();
         if(this.xpBoost < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBoost + ") on element of MonsterBoosts.xpBoost.");
         }
         this.dropBoost = param1.readVarUhShort();
         if(this.dropBoost < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBoost + ") on element of MonsterBoosts.dropBoost.");
         }
    }

}