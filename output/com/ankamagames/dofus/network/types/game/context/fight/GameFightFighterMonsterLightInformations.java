package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightFighterMonsterLightInformations extends GameFightFighterLightInformations implements INetworkType {

    private int protocolId = 455;
    private int creatureGenericId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterLightInformations(param1);
         if(this.creatureGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element creatureGenericId.");
         }
         param1.writeVarShort(this.creatureGenericId);
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
         this.creatureGenericId = param1.readVarUhShort();
         if(this.creatureGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element of GameFightFighterMonsterLightInformations.creatureGenericId.");
         }
    }

}