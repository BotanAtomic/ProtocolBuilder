package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightFighterLightInformations extends Object implements INetworkType {

    private int protocolId = 413;
    private Number id = 0;
    private int wave = 0;
    private int level = 0;
    private int breed = 0;
    private boolean sex = false;
    private boolean alive = false;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.sex);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.alive);
         param1.writeByte(_loc2_);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
         }
         param1.writeByte(this.wave);
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeVarShort(this.level);
         param1.writeByte(this.breed);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.alive = BooleanByteWrapper.getFlag(_loc2_,1);
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of GameFightFighterLightInformations.id.");
         }
         this.wave = param1.readByte();
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element of GameFightFighterLightInformations.wave.");
         }
         this.level = param1.readVarUhShort();
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GameFightFighterLightInformations.level.");
         }
         this.breed = param1.readByte();
    }

}