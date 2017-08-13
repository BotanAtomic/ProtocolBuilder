package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class GameFightJoinMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 702;
    private boolean _isInitialized = false;
    private boolean isTeamPhase = false;
    private boolean canBeCancelled = false;
    private boolean canSayReady = false;
    private boolean isFightStarted = false;
    private int timeMaxBeforeFightStart = 0;
    private int fightType = 0;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.isTeamPhase);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.canBeCancelled);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.canSayReady);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.isFightStarted);
         param1.writeByte(_loc2_);
         if(this.timeMaxBeforeFightStart < 0)
         {
            throw new Exception("Forbidden value (" + this.timeMaxBeforeFightStart + ") on element timeMaxBeforeFightStart.");
         }
         param1.writeShort(this.timeMaxBeforeFightStart);
         param1.writeByte(this.fightType);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.isTeamPhase = BooleanByteWrapper.getFlag(_loc2_,0);
         this.canBeCancelled = BooleanByteWrapper.getFlag(_loc2_,1);
         this.canSayReady = BooleanByteWrapper.getFlag(_loc2_,2);
         this.isFightStarted = BooleanByteWrapper.getFlag(_loc2_,3);
         this.timeMaxBeforeFightStart = param1.readShort();
         if(this.timeMaxBeforeFightStart < 0)
         {
            throw new Exception("Forbidden value (" + this.timeMaxBeforeFightStart + ") on element of GameFightJoinMessage.timeMaxBeforeFightStart.");
         }
         this.fightType = param1.readByte();
         if(this.fightType < 0)
         {
            throw new Exception("Forbidden value (" + this.fightType + ") on element of GameFightJoinMessage.fightType.");
         }
    }

}