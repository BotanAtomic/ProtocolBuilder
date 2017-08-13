package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareCriteria;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class DareCreationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6665;
    private boolean _isInitialized = false;
    private Number subscriptionFee = 0;
    private Number jackpot = 0;
    private int maxCountWinners = 0;
    private int delayBeforeStart = 0;
    private int duration = 0;
    private boolean isPrivate = false;
    private boolean isForGuild = false;
    private boolean isForAlliance = false;
    private boolean needNotifications = false;
    private DareCriteria[] criterions;
    private FuncTree _criterionstree;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.isPrivate);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isForGuild);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isForAlliance);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.needNotifications);
         param1.writeByte(_loc2_);
         if(this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionFee + ") on element subscriptionFee.");
         }
         param1.writeVarLong(this.subscriptionFee);
         if(this.jackpot < 0 || this.jackpot > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jackpot + ") on element jackpot.");
         }
         param1.writeVarLong(this.jackpot);
         if(this.maxCountWinners < 0 || this.maxCountWinners > 65535)
         {
            throw new Exception("Forbidden value (" + this.maxCountWinners + ") on element maxCountWinners.");
         }
         param1.writeShort(this.maxCountWinners);
         if(this.delayBeforeStart < 0 || this.delayBeforeStart > 4.294967295E9)
         {
            throw new Exception("Forbidden value (" + this.delayBeforeStart + ") on element delayBeforeStart.");
         }
         param1.writeUnsignedInt(this.delayBeforeStart);
         if(this.duration < 0 || this.duration > 4.294967295E9)
         {
            throw new Exception("Forbidden value (" + this.duration + ") on element duration.");
         }
         param1.writeUnsignedInt(this.duration);
         param1.writeShort(this.criterions.length);
         int _loc3_ = 0;
         while(_loc3_ < this.criterions.length)
         {
            (this.criterions[_loc3_] as DareCriteria).serializeAs_DareCriteria(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         DareCriteria _loc4_ = null;
         int _loc2_ = param1.readByte();
         this.isPrivate = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isForGuild = BooleanByteWrapper.getFlag(_loc2_,1);
         this.isForAlliance = BooleanByteWrapper.getFlag(_loc2_,2);
         this.needNotifications = BooleanByteWrapper.getFlag(_loc2_,3);
         this.subscriptionFee = param1.readVarUhLong();
         if(this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionFee + ") on element of DareCreationRequestMessage.subscriptionFee.");
         }
         this.jackpot = param1.readVarUhLong();
         if(this.jackpot < 0 || this.jackpot > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jackpot + ") on element of DareCreationRequestMessage.jackpot.");
         }
         this.maxCountWinners = param1.readUnsignedShort();
         if(this.maxCountWinners < 0 || this.maxCountWinners > 65535)
         {
            throw new Exception("Forbidden value (" + this.maxCountWinners + ") on element of DareCreationRequestMessage.maxCountWinners.");
         }
         this.delayBeforeStart = param1.readUnsignedInt();
         if(this.delayBeforeStart < 0 || this.delayBeforeStart > 4.294967295E9)
         {
            throw new Exception("Forbidden value (" + this.delayBeforeStart + ") on element of DareCreationRequestMessage.delayBeforeStart.");
         }
         this.duration = param1.readUnsignedInt();
         if(this.duration < 0 || this.duration > 4.294967295E9)
         {
            throw new Exception("Forbidden value (" + this.duration + ") on element of DareCreationRequestMessage.duration.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DareCriteria();
            _loc4_.deserialize(param1);
            this.criterions.push(_loc4_);
            _loc3_++;
         }
    }

}