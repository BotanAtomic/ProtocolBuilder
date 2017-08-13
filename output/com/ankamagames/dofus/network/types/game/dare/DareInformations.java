package com.ankamagames.dofus.network.types.game.dare;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.CharacterBasicMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DareInformations extends Object implements INetworkType {

    private int protocolId = 502;
    private Number dareId = 0;
    private CharacterBasicMinimalInformations creator;
    private Number subscriptionFee = 0;
    private Number jackpot = 0;
    private int maxCountWinners = 0;
    private Number endDate = 0;
    private boolean isPrivate = false;
    private int guildId = 0;
    private int allianceId = 0;
    private DareCriteria[] criterions;
    private Number startDate = 0;
    private FuncTree _creatortree;
    private FuncTree _criterionstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
         this.creator.serializeAs_CharacterBasicMinimalInformations(param1);
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
         if(this.endDate < 0 || this.endDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.endDate + ") on element endDate.");
         }
         param1.writeDouble(this.endDate);
         param1.writeBoolean(this.isPrivate);
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
         }
         param1.writeVarInt(this.allianceId);
         param1.writeShort(this.criterions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.criterions.length)
         {
            (this.criterions[_loc2_] as DareCriteria).serializeAs_DareCriteria(param1);
            _loc2_++;
         }
         if(this.startDate < 0 || this.startDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.startDate + ") on element startDate.");
         }
         param1.writeDouble(this.startDate);
    }

    public void deserialize(ICustomDataInput param1) {
         DareCriteria _loc4_ = null;
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareInformations.dareId.");
         }
         this.creator = new CharacterBasicMinimalInformations();
         this.creator.deserialize(param1);
         this.subscriptionFee = param1.readVarUhLong();
         if(this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionFee + ") on element of DareInformations.subscriptionFee.");
         }
         this.jackpot = param1.readVarUhLong();
         if(this.jackpot < 0 || this.jackpot > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jackpot + ") on element of DareInformations.jackpot.");
         }
         this.maxCountWinners = param1.readUnsignedShort();
         if(this.maxCountWinners < 0 || this.maxCountWinners > 65535)
         {
            throw new Exception("Forbidden value (" + this.maxCountWinners + ") on element of DareInformations.maxCountWinners.");
         }
         this.endDate = param1.readDouble();
         if(this.endDate < 0 || this.endDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.endDate + ") on element of DareInformations.endDate.");
         }
         this.isPrivate = param1.readBoolean();
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of DareInformations.guildId.");
         }
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of DareInformations.allianceId.");
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
         this.startDate = param1.readDouble();
         if(this.startDate < 0 || this.startDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.startDate + ") on element of DareInformations.startDate.");
         }
    }

}