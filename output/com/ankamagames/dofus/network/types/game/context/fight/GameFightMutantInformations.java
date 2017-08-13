package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightMutantInformations extends GameFightFighterNamedInformations implements INetworkType {

    private int protocolId = 50;
    private int powerLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterInformations(param1);
         param1.writeUTF(this.name);
         this.status.serializeAs_PlayerStatus(param1);
         if(this.powerLevel < 0)
         {
            throw new Exception("Forbidden value (" + this.powerLevel + ") on element powerLevel.");
         }
         param1.writeByte(this.powerLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc5_ = 0;
         this.deserializeAs_GameContextActorInformations(param1);
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightFighterInformations.teamId.");
         }
         this.wave = param1.readByte();
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element of GameFightFighterInformations.wave.");
         }
         this.alive = param1.readBoolean();
         int _loc2_ = param1.readUnsignedShort();
         this.stats = ProtocolTypeManager.getInstance(GameFightMinimalStats,_loc2_);
         this.stats.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
         {
            _loc5_ = param1.readVarUhShort();
            if(_loc5_ < 0 || _loc5_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc5_ + ") on elements of previousPositions.");
            }
            this.previousPositions.push(_loc5_);
            _loc4_++;
         }
         this.name = param1.readUTF();
         this.status = new PlayerStatus();
         this.status.deserialize(param1);
         this.powerLevel = param1.readByte();
         if(this.powerLevel < 0)
         {
            throw new Exception("Forbidden value (" + this.powerLevel + ") on element of GameFightMutantInformations.powerLevel.");
         }
    }

}